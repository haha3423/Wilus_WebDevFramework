import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.2"
    id("io.spring.dependency-management") version "1.1.4"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.9.22"

    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"

}

group = "com.wilus"
version = "1.0"
val queryDslVersion = "5.0.0" // QueryDSL Version Setting

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["snippetsDir"] = file("build/generated-snippets")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    /* HttpRequest */
    implementation("io.netty", "netty-all", "4.1.86.Final")

    implementation("org.jetbrains.kotlin:kotlin-reflect:1.9.10")
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.10")

    /* Lombok */
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    /* About DB */
    implementation("org.hibernate.orm", "hibernate-core", "6.3.1.Final")
    implementation("javax.persistence", "javax.persistence-api", "2.2")

    runtimeOnly("com.oracle.database.jdbc:ojdbc8") // 아래 수동으로 ojdbc8 등 임포트
    // implementation fileTree(dir:  '/src/main/webapp/WEB-INF/lib', include: ['*.jar'])
    implementation("com.oracle.ojdbc", "orai18n", "19.3.0.0")
    implementation("com.zaxxer", "HikariCP", "4.0.3")
    runtimeOnly("com.h2database:h2")

}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
