import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.0.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
    kotlin("jvm") version "1.3.50"
    kotlin("plugin.spring") version "1.3.50"
    kotlin("plugin.jpa") version "1.3.50"
    kotlin("kapt") version "1.3.31"
    idea	// idea를 사용 할 수 있게 해줌

}

group = "com.travelwith"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}

repositories {
    mavenCentral()
}

val querydslVersion = "4.2.1"
val swaggerVersion = "2.9.2"
val swaggerAnnotationVersion = "1.5.21"
val flywayVersion = "5.2.4"

dependencies {

    // swagger
    implementation("io.springfox:springfox-swagger2:$swaggerVersion") {
        exclude("io.swagger:swagger-annotations")
        exclude("io.swagger:swagger-models")
    }
    implementation("io.springfox:springfox-swagger-ui:$swaggerVersion")
    // swagger ui 접속시 NumberFormatException 해결
    implementation("io.swagger:swagger-annotations:$swaggerAnnotationVersion")
    implementation("io.swagger:swagger-models:$swaggerAnnotationVersion")


    //query-dsl
    implementation("com.querydsl:querydsl-jpa:$querydslVersion")
    implementation("com.querydsl:querydsl-sql:$querydslVersion")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jpa")

    //flyway
    implementation("org.flywaydb:flyway-core:$flywayVersion")

    implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.session:spring-session-core")

    // map-struct
    implementation("org.mapstruct:mapstruct:1.3.0.Final")
    kapt("org.mapstruct:mapstruct-processor:1.3.0.Final")
    kaptTest("org.mapstruct:mapstruct-processor:1.3.0.Final")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("mysql:mysql-connector-java")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
    testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// queryDSL Qclass 저장위치
idea {
    module {
        val kaptMain = file("$buildDir/generated/source/kapt/main")
        sourceDirs.add(kaptMain)
        generatedSourceDirs.add(kaptMain)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
