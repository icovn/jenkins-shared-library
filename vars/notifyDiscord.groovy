//https://plugins.jenkins.io/discord-notifier/

/**
 *
 * @param config
 * @return
 */
def call(Map config=[:]) {
    def discordUrl = credentials("discord-url")
    if (config.type == "docker") {
        discordUrl = credentials("discord-url-docker")
    }
    if (config.type == "testFlight") {
        discordUrl = credentials("discord-url-test-flight")
    }
    if (config.type == "unity") {
        discordUrl = credentials("discord-url-unity")
    }

    discordSend webhookURL: discordUrl, title: config.title, description: config.description
}
