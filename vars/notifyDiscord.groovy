//https://plugins.jenkins.io/discord-notifier/

/**
 * Send notify to Discord with credentials:
 * - discord-url
 * - discord-url-docker
 * - discord-url-test-flight
 * - discord-url-unity
 * @param config
 * @return
 */
def call(Map config=[:]) {
    def discordUrl = credentials id: 'discord-url'
    if (config.type == "docker") {
        discordUrl = credentials id: 'discord-url-docker'
    }
    if (config.type == "testFlight") {
        discordUrl = credentials id: 'discord-url-test-flight'
    }
    if (config.type == "unity") {
        discordUrl = credentials id: 'discord-url-unity'
    }

    info "discordUrl: ${discordUrl}"
    discordSend webhookURL: discordUrl, title: config.title, description: config.description
}
