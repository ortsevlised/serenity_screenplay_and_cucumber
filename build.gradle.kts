plugins {
    kotlin("jvm") version "1.9.22"
    id("net.serenity-bdd.serenity-gradle-plugin") version "4.0.30"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


sourceSets {
    create("unitTests") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

configurations["unitTestsImplementation"].extendsFrom(configurations.runtimeOnly.get())

val unitTestsImplementation: Configuration by configurations.getting {
    extendsFrom(configurations.implementation.get())
}

val serenity_version by extra("4.0.30")
val junit_platform_launcher_version = "1.10.1"
val cucumber_junit_platform_engine_version = "7.14.0"
val junit_platform_suite_version = "1.10.1"
val junit_jupiter_engine_version = "5.10.1"
val junit_vintage_engine_version = "5.10.1"
val logback_classic_version = "1.4.14"
val assertj_core_version = "3.25.1"

dependencies {
    implementation(kotlin("stdlib"))
    unitTestsImplementation("org.junit.platform:junit-platform-launcher:${junit_platform_launcher_version}")
    unitTestsImplementation("org.junit.platform:junit-platform-suite:${junit_platform_suite_version}")
    unitTestsImplementation("org.junit.jupiter:junit-jupiter-engine:${junit_jupiter_engine_version}")
    unitTestsImplementation("org.junit.vintage:junit-vintage-engine:${junit_vintage_engine_version}")
    testImplementation("net.serenity-bdd:serenity-cucumber:${serenity_version}")
    testImplementation("net.serenity-bdd:serenity-screenplay:${serenity_version}")
    testImplementation("net.serenity-bdd:serenity-ensure:${serenity_version}")
    testImplementation("org.junit.platform:junit-platform-launcher:${junit_platform_launcher_version}")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:${cucumber_junit_platform_engine_version}")
    testImplementation("org.junit.platform:junit-platform-suite:${junit_platform_suite_version}")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:${junit_jupiter_engine_version}")
    testImplementation("org.junit.vintage:junit-vintage-engine:${junit_vintage_engine_version}")
    implementation("ch.qos.logback:logback-classic:${logback_classic_version}")
    testImplementation("org.assertj:assertj-core:${assertj_core_version}")
}


val reportsDirProperty: String? by project


val unitTests = task<Test>("unitTests") {
    description = "Runs unit tests."
    group = "verification"

    testClassesDirs = sourceSets["unitTests"].output.classesDirs
    classpath = sourceSets["unitTests"].runtimeClasspath
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        outputs.upToDateWhen { false }
        showStandardStreams = true
    }
    val reportsDirPath = reportsDirProperty ?: "reports/bdd_scenarios"
    reports {
        html.outputLocation = file(reportsDirPath)
        junitXml.outputLocation = file("$reportsDirPath/xml")
    }
}

tasks.getByName<Test>("unitTests") {
    useJUnitPlatform()
    testLogging {
        outputs.upToDateWhen { false }
        showStandardStreams = true
    }

    val reportsDirPath = reportsDirProperty ?: "reports/unit_tests"
    reports {
        html.outputLocation = file(reportsDirPath)
        junitXml.outputLocation = file("$reportsDirPath/xml")
    }
}

tasks.register<Exec>("runPythonScript") {
    commandLine("python3", "simple-calc-test-runner.py", "--run", "scenarios", "--reports-dir", "reports")
}
