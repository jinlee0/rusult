import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.archivesName

buildscript {
    dependencies {
        classpath("io.github.gradle-nexus:publish-plugin:1.1.0")
    }
}

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.9.10"
    `java-library`
}

group = "io.github.jinlee0"
archivesName = "rusult"
version = "0.1.1"

repositories {
    mavenCentral()
}

apply {
    plugin("io.github.gradle-nexus.publish-plugin")
    from("$rootDir/scripts/publish-maven.gradle")
    from("publish.gradle")
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
