# f20-project-team4

## 17480/780 final project - Java-Gitlab-API.

This project aims to improve [Java-Gitlab-API](https://github.com/timols/java-gitlab-api), a wrapper for [Gitlab Web
 API](https://docs.gitlab.com/ee/api/)
 

## Example Code
### Authentication
```java
    // Connect to Gitlab via access token
        GitlabAPIClient client = new GitlabAPIClient
                .Builder("https://gitlab.com")
                .withAccessToken(System.getenv("TOKEN"))
                .build();
```

### Get All Project of a User
```java
    List<GitlabProject> projects = client.getUserProjectsQuery(client.getCurrentUser().getUsername()).query();
    for (GitlabProject p : projects) {
        System.out.println("ProjectID: " + p.getId() + " Title: " + p.getName());
    }
```
### Fork a Project
```java
        GitlabProject project = client.getProject("api", "team4");
        // fork a project
        GitlabProject projectForked = project.fork();
        System.out.println("project " + projectForked.getId() + "forked from project " + project.getId());
        System.out.println("Project " +project.getId() + "is forked " + project.getForksCount() + " times");
```

### Decline a Merge Request
```java
        GitlabProject project = client.getProject("api", "team4");
        GitlabMergeRequest req = project.getMergeRequest(12345);
        // Decline a merge request
        req.decline();
```

### Query Issues
```java
        // Query all merge requests visible to current user
        List<GitlabIssue> allIssues = CLIENT.getIssuesQuery().query();
        // Query all issues under this project
        List<GitlabIssue> allProjectIssues = project.getIssuesQuery().query();
```

### Create Branch
```java
        GitlabProject project = client.getProject("api", "team4");
        GitlabBranch branch = project.newBranch("branch", "master").create();
```

### Reports
[Java doc](https://apiteam4.gitlab.io/f20-project-team4) <br />
[Client code](https://github.com/cmu-api-design/f20-project-team4/tree/master/src/example/java/core)  <br />
[Final report](https://docs.google.com/document/d/1Nqpl4rBEIyOsy8u2sGvIxyIZV9nhyBUAdIysCqufRnA/edit)  <br />
[Proposal](https://docs.google.com/document/d/1VdSe0X-w4BV-EYYps5XtZoON-E6No9vJtT9rtb9ipfw/edit)   <br />
