// Jenkins Job DSL to create Job

def basePath = 'BigProject';

folder (basePath) {
  displayName('BigProject');
  description('Folder for BigProject');
}



def repoUrl = "https://github.com/thevictorgreen/nodemicro.git"; //Repository UrL

pipelineJob(basePath + "/NodeMicro") { //JobName
  description("NodeJS Micro Service");
  definition {
    cpsScm {
      scriptPath("app/JenkinsFile"); //Path to Build Script
      scm {
        git {
          remote {
            url(repoUrl); //Git Repository
            branch("master");
          }
        }
      }
    }
  }
}
