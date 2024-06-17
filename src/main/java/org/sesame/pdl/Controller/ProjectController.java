package org.sesame.pdl.Controller;

import lombok.AllArgsConstructor;
import org.sesame.pdl.Entity.Project;
import org.sesame.pdl.Service.IProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/Project")
@CrossOrigin(origins = "*")
public class ProjectController {

    private IProjectService projectService;

    @GetMapping("/getAll")
    public List<Project> getAllProject()
    {
        return projectService.getAllProject();
    }

    @GetMapping ("/getById/{idProject}")
    public Project getProjectById (@PathVariable  int idProject)
    {
        return projectService.getProjectById(idProject);
    }

    @PostMapping ("/addProject")
    public Project saveProject(@RequestBody Project project)
    {
       return projectService.saveProject(project);
    }

    @PutMapping ("/updateProject/{idProject}")
    public Project updateProject(@RequestBody Project project , @PathVariable int idProject )
    {
        project.setIdProject(idProject);
        return projectService.updateProject(project,idProject);
    }

    @DeleteMapping ("/delete/{idProject}")
    public void deleteProject(@PathVariable int idProject)
    {

        projectService.deleteProject(idProject);
    }

    @PutMapping("/affecterUser/{fullName}")
    public void affecterUserProject(@PathVariable String fullName, @RequestBody Project project)
    {
        projectService.affecterUserProject(fullName,project);
    }
}
