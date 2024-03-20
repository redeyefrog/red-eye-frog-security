# Security

## Spring Security
1. Dependency
   * With Spring Boot
   ```xml
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
   ```
   * Without Spring Boot
   ```xml
    <dependencies>
        <!-- ... other dependency elements ... -->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-config</artifactId>
        </dependency>
    </dependencies>
   ```
2. Reference
   * [使用Spring Security](https://openhome.cc/Gossip/Spring/SpringSecurity.html)
   * [Getting Spring Security](https://docs.spring.io/spring-security/reference/getting-spring-security.html)
   * [Security with Spring](https://www.baeldung.com/security-spring)
   * [Spring Security without the WebSecurityConfigurerAdapter](https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)

## Spring Data JPA
#### Automatic schema generation
**`spring.jpa.hibernate.ddl-auto` This is actually a shortcut for the `spring.jpa.properties.hibernate.hbm2ddl.auto` property**
1. `none (default)` No action will be performed.
2. `create-only` Database creation will be generated.
3. `drop` Database dropping will be generated.
4. `create` Database dropping will be generated followed by database creation.
5. `create-drop` Drop the schema and recreate it on SessionFactory startup. Additionally, drop the schema on SessionFactory shutdown.
6. `validate` Validate the database schema.
7. `update` Update the database schema.

## Log4j2
1. Dependency
   ```xml
    <dependencies>
        <!-- ... other dependency elements ... -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-logging</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-log4j2</artifactId>
        </dependency>
        <!-- for recognize log4j2 yaml file-->
        <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-yaml</artifactId>
        </dependency>
    </dependencies>
   ```
2. Reference
   * [Log4j – Configuring Log4j 2](https://logging.apache.org/log4j/2.x/manual/configuration.html)
   * [Log4j – Log4j 2 Layouts](http://logging.apache.org/log4j/2.x/manual/layouts.html)