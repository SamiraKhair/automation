plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.seleniumhq.selenium:selenium-java:4.27.0")
    testImplementation("org.testng:testng:7.10.2")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.9.2")
    implementation("org.apache.poi:poi:5.3.0")                     // For handling Excel files
    implementation("org.apache.poi:poi-ooxml:5.3.0")




}

tasks.test {
    useTestNG()
}