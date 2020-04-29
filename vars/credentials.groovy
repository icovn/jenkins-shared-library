import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.*
import com.cloudbees.plugins.credentials.Credentials
import com.cloudbees.plugins.credentials.CredentialsProvider

/**
 * Get credential by id
 * @param config Map variables: id
 * @return
 */
def call(Map config=[:]) {
    def jenkinsCredentials = CredentialsProvider.lookupCredentials(
            Credentials.class,
            Jenkins.instance
    );
    for (credential in jenkinsCredentials) {
        if(credential.id == config.id){
            return credential.secret
        }
    }
}