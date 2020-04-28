//https://plugins.jenkins.io/discord-notifier/

/**
 *
 * @param config
 * @return
 */
def call(Map config=[:]) {
    def discordUrl = credentials("discordUrl")
    if (config.type == "docker") {
        discordUrl = credentials("discordUrlDocker")
    }
    if (config.type == "testFlight") {
        discordUrl = credentials("discordUrlTestFlight")
    }
    if (config.type == "unity") {
        discordUrl = credentials("discordUrlUnity")
    }

    discordSend webhookURL: discordUrl, title: config.title, description: config.description
}
