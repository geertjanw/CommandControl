plugins {
    java
}

repositories {
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
}

dependencies {
    implementation(project(":core"))

    implementation("org.bstats:bstats-bungeecord:2.2.1")
    compileOnly("io.github.waterfallmc:waterfall-api:1.16-R0.4-SNAPSHOT")
}