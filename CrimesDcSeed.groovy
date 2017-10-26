// Jenkins Job DSL to create Jobs

//Base Path For All Jobs Related to this project
def basePath = 'BigProject';

//Folder already exists. Seed job inside of it
folder (basePath) {
  displayName('BigProject');
  description('Folder for BigProject');
}


//Git repository for this project
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
      triggers {
        scm('H/5 * * * *');
      }
    }
  }
}

//Git repository for this project
/*
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
*/
