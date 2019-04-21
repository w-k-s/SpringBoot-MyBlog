# My Blog

A project to try out various Spring Technologies.

**Stage 1**

- [x] A boot JAR using spring boot.
- [x] Rest endpoints that can return a `JSON` response.
- [x] Endpoint that returns an HTML page with a model from java using `thymeleaf`
- [x] Models should be picked up from DB using `JPA` we will use `Hibernate`.
- [x] *must* have `unit-test` and `mockMVC` tests.
- [x] For the models you should use an `SQL` db recommended `MySql`
- [x] The endpoints should be secured with basic auth and the user data should be on a in memory db like `H2` (edited)
- [x] Make the db boot in a docker container.
- [x] Configure the db url with a YAML

**Stage 2**

- [x] Play with restTemplate and its reactive counterpart webClient
- [x] Play around with Flux<> Mono<> and find limitations on full reactive stack (MySQL driver)

> If you want all the benefits of reactive, async / non-blocking, you'll need to make the whole stack async / non-blocking. 
> JDBC is indeed inherently a blocking API, so you can't build a fully reactive / non-blocking app if you need to access the database through JDBC.
> If you still need a relational database then I recommend [rxjava2-jdbc](https://github.com/chang-chao/spring-webflux-async-jdbc-sample)
>
> https://stackoverflow.com/questions/52480271/spring-webflux-jpa-reactive-repositories-are-not-supported-by-jpa

- [x] Service discovery through [Eureka](https://www.baeldung.com/spring-cloud-netflix-eureka)
- [x] Check out [feign client](https://www.baeldung.com/spring-cloud-openfeign)
- [ ] Pick up configurations at start time through a config-server
- [ ] Get integration tests up and running.