package com.laioffer.twitch.favorite;

import com.laioffer.twitch.db.entity.UserEntity;
import com.laioffer.twitch.model.FavoriteRequestBody;
import com.laioffer.twitch.model.TypeGroupedItemList;
import com.laioffer.twitch.user.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.relational.core.conversion.DbActionExecutionException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;



@RestController
@RequestMapping("/favorite")
public class FavoriteController {


    private MyFavoriteService myFavoriteService;
    private UserService userService;

    private final UserEntity userEntity = new UserEntity(1L, "user0", "Foo", "Bar", "password");
    public FavoriteController(MyFavoriteService myFavoriteService, UserService userService) {
        this.myFavoriteService = myFavoriteService;
        this.userService = userService;
    }
    @GetMapping
    public TypeGroupedItemList getFavoriteItems(@AuthenticationPrincipal User user) {
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        return myFavoriteService.getGroupedFavoriteItems(userEntity);
    }


    @PostMapping
    public void setFavoriteItem(@AuthenticationPrincipal User user, @RequestBody FavoriteRequestBody body) {
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        try {
            myFavoriteService.setFavoriteItem(userEntity, body.favorite());
        } catch (DbActionExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof DataIntegrityViolationException) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicate entry for favorite record", e);
            } else {
                throw e;
            }
        }
    }


    @DeleteMapping
    public void unsetFavoriteItem(@AuthenticationPrincipal User user, @RequestBody FavoriteRequestBody body) {
        UserEntity userEntity = userService.findByUsername(user.getUsername());
        myFavoriteService.unsetFavoriteItem(userEntity, body.favorite().twitchId());
    }
}









