package org.sesame.pdl.Service;

import org.sesame.pdl.Entity.Project;

import java.util.List;

public interface IProjectService {
    public Project saveProject(Project project);
    public  Project updateProject(Project project, int idProject);
    public void deleteProject(int idProject);
    public List<Project> getAllProject();
    public Project getProjectById (int idProject);

    public void affecterUserProject (String fullName , Project project);
}
