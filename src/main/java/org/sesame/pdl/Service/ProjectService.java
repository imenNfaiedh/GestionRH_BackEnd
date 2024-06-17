package org.sesame.pdl.Service;

import lombok.AllArgsConstructor;
import org.sesame.pdl.Entity.Project;
import org.sesame.pdl.Entity.User;
import org.sesame.pdl.Repository.IProjectRepository;
import org.sesame.pdl.Repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor

public class ProjectService implements IProjectService {

    private IProjectRepository projectRepository;
    private IUserRepository userRepository;
    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Project project, int idProject) {
        if(!projectRepository.existsById(project.getIdProject()))
        {
            throw new RuntimeException("Project not found ");
        }
        Project projectToUpdate =projectRepository .findById(idProject).get();
        projectToUpdate.setName(project.getName());
        projectToUpdate.setName(project. getDescription());
        projectToUpdate.setName(project.getName());
        projectToUpdate.setName(project.getName());
        return projectRepository.save(projectToUpdate);
    }

    @Override
    public void deleteProject(int idProject) {
        projectRepository.deleteById(idProject);


    }

    @Override
    public List<Project> getAllProject() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project getProjectById(int idProject) {
        return projectRepository.findById(idProject)
                .orElseThrow(() -> new RuntimeException("Project not not found with id : " +idProject) );
    }

    @Override
    public void affecterUserProject(String fullName, Project project) {

        User user = userRepository.findByFullName(fullName).orElse(null);
        if (user != null) {
            project.setUser(user);
            projectRepository.save(project);
        } else {
            // Gestion du cas où l'utilisateur n'est pas trouvé
            throw new RuntimeException("User not found with fullname: " +fullName);
        }
    }
}
