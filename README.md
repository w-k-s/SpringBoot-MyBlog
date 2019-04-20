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

- [ ] Play with restTemplate and its reactive counterpart webClient
- [ ] Play around with Flux<> Mono<> and find limitations on full reactive stack (MySQL driver)
- [ ] Service discovery through Eureka
- [ ] Pick up configurations at start time through a config-server
- [ ] Check out feign client
- [ ] Get integration tests up and running.