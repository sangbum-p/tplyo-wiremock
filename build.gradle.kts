plugins {
    java
    id("org.springframework.boot") version "3.3.1"
    id("io.spring.dependency-management") version "1.1.5"
    id("org.springdoc.openapi-gradle-plugin") version "1.6.0"
    id("com.diffplug.spotless") version "6.21.0"
}

group = "com.wesang"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

spotless {
    val excludeFiles = arrayOf(".idea/**/*.*", ".vscode/**/*.*")

    java {
        targetExclude("build/**/*.java")
        removeUnusedImports()
        replaceRegex("Remove wildcard imports", "import\\s+[^\\*\\s]+\\*;(\\r\\n|\\r|\\n)", "$1")
        googleJavaFormat()
        importOrder(
            "java",
            "jakarta",
            "javax",
            "lombok",
            "org.springframework",
            "",
            "\\#",
            "org.junit",
            "\\#org.junit",
            "com.wesang",
            "\\#com.wesang"
        )
        indentWithTabs(2)
        indentWithSpaces(4)
        trimTrailingWhitespace()
        endWithNewline()
    }
    format("yaml") {
        target("**/*.yaml", "**/*.yml")
        targetExclude(*excludeFiles)
    }
    format("xml") {
        target("**/*.xml")
        targetExclude(*excludeFiles)
    }
    format("md") {
        target("**/*.md")
        targetExclude(*excludeFiles)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.0.2")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
