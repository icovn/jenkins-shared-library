//https://plugins.jenkins.io/discord-notifier/

/**
 *
 * @param config
 * @return
 */
def call(Map config=[:]) {
    def discordUrl = env.DISCORD_URL
    if (config.type == "docker") {
        discordUrl = env.DISCORD_URL_DOCKER
    }
    if (config.type == "testFlight") {
        discordUrl = env.DISCORD_URL_TEST_FLIGHT
    }
    if (config.type == "unity") {
        discordUrl = env.DISCORD_URL_UNITY
    }

    discordSend webhookURL: discordUrl, title: config.title, description: config.description
}
