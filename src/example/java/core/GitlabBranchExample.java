package core;
import org.gitlab.api.core.*;

import java.util.List;
public class GitlabBranchExample {
    public static void main(String[] args) {
        // Connect to Gitlab via access token
        GitlabAPIClient CLIENT =
                GitlabAPIClient.fromAccessToken("https://gitlab.com", System.getenv("TOKEN"));
        GitlabProject project = CLIENT.newProject("example-project").create();

        // create new branches
        GitlabBranch branch1 = project.newBranch("branch1", "master").create();
        GitlabBranch branch2 = project.newBranch("branch2", branch1.getName()).create();

        // set to default branch
        project.withDefaultBranch(branch1.getName()).update();
        if (branch1.isDefault()) System.out.println(branch1.getName() + " is the default branch");

        // query all branches under a project
        List<GitlabBranch> branchesInProject = project.branches().query();
        System.out.println(project.getName() + " has " + branchesInProject.size() + " branches");

        // delete branch (default branch cannot be deleted)
        branch2.delete();

        project.delete();

    }
}
