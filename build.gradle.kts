// TODO: maybe convert this to a multi-module project?
plugins {
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("java")
    `maven-publish`
}

group = "com.comugamers"
version = "1.0-SNAPSHOT"

tasks {
    shadowJar {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")

        val pkg = "com.comugamers.i18n.internal"

        relocate("dev.triumphteam", "$pkg.triumphteam")
        relocate("me.yushust", "$pkg.yushust")
        relocate("team.unnamed", "$pkg.unnamed")
    }

    named<DefaultTask>("build") {
        dependsOn("shadowJar")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = project.name
            from(components["java"])
        }
    }
}

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.unnamed.team/repository/unnamed-public/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://repo.triumphteam.dev/snapshots/")
}

dependencies {
    // dependencies that are only required during compile time
    compileOnly("me.clip:placeholderapi:2.11.2")
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")

    // dependencies that should be shaded in the final JAR
    implementation("team.unnamed:inject:1.0.1")
    implementation("me.yushust.message:core:7.1.0")
    implementation("me.yushust.message:sourcetype-bukkit-yml:7.1.0")
    implementation("dev.triumphteam:triumph-cmd-bukkit:2.0.0-SNAPSHOT")

    // dependencies required during testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

bukkit {
    val projectName = "${findProperty("plugin-name")}"

    main = "com.comugamers.i18n.MultiLangPlugin"
    apiVersion = "1.13"
    version = "${project.version}"
    authors = listOf("Pabszito")
    description = "Add multi-language support to your server!"
    website = "www.comugamers.com"
    depend = listOf("PlaceholderAPI")
    name = projectName
}