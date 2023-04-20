#  A Full-Stack Personalized Twitch Recommendation Platform

* Designed and built a full-stack web application for users to search twitch resources (stream/video/clip) and get recommendations. 

* Built a web page with rich + user friendly experience using React and Ant Design

* Implemented RESTful APIs using Java servlets, retrieved real Twitch resources using Twitch
APIs with Spring declarative HTTP client.

* Hosted a MySQL database on AWS RDS, implementing CRUD operations with Spring Data
JDBC for efficient data access and manipulation.

* Implemented Spring Boot Caching with Caffeine to improve application performance

--- 

#### Demo1: register
<img src="https://github.com/yixiuzhu/GameHere/blob/78ae803558835f0007bff07cba4a03335b63ff07/demo/demo_register.gif" width=650 height=360 />

#### Demo2: log in
<img src="https://github.com/yixiuzhu/GameHere/blob/78ae803558835f0007bff07cba4a03335b63ff07/demo/demo_login_popular.gif" width=650 height=360 />

#### Demo3: get popular games
<img src="https://github.com/yixiuzhu/GameHere/blob/78ae803558835f0007bff07cba4a03335b63ff07/demo/demo_popular.gif" width=650 height=360 />

#### Demo4: custom search
<img src="https://github.com/yixiuzhu/GameHere/blob/78ae803558835f0007bff07cba4a03335b63ff07/demo/demo_search.gif" width=650 height=360 />

#### Demo5: my favorite
<img src="https://github.com/yixiuzhu/GameHere/blob/78ae803558835f0007bff07cba4a03335b63ff07/demo/demo_fav.gif" width=650 height=360 />

#### Demo6: recommendation according to users' favorite records
<img src="https://github.com/yixiuzhu/GameHere/blob/78ae803558835f0007bff07cba4a03335b63ff07/demo/demo_recom.gif" width=650 height=360 />

---
#### Load testing:

Apache JMeter is used to conduct a load testing on this project.

![image_without_connection_pool](https://cdn.jsdelivr.net/gh/lichever/pictureBedForNormalUse@main/uPic/image-20210708004453595_2021_07_08_17_29_19.png  "result with no connection pool")



The bottleneck is the connection to the database, and thus, the MySQL JDBC connection pool is used to improve the performance of this project. As can be seen, the throughput has a huge increase by using the connection pool.

![image_with_connection pool](https://cdn.jsdelivr.net/gh/lichever/pictureBedForNormalUse@main/uPic/image-20210708141911048_2021_07_08_14_19_13.png "result with connection pool")
