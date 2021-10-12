package chap4;

import java.util.ArrayList;
import java.util.HashSet;

public class a4x7BuildOrderProblem {

    public ArrayList buildOrder(ArrayList<ArrayList> dependencies, ArrayList project){
        ArrayList result = new ArrayList();

        HashSet currentDependencies = new HashSet();
        ArrayList path = new ArrayList();
        fillAllInitialDependencies(currentDependencies, dependencies,project, path);
        HashSet nextDependencies = new HashSet();
        while(!currentDependencies.isEmpty()){
            for(int i = 0 ; i<dependencies.size(); i++){
                nextDependencies = new HashSet();
                if(currentDependencies.contains(dependencies.get(i).get(0))){
                    nextDependencies.add(dependencies.get(i).get(1));
                    path.add(dependencies.get(i).get(0));
                }
                currentDependencies = nextDependencies;
            }
        }

        return result;
    }

    /**
     * this is going to find the dependencies that we can start working on without
     * worrying about other dependencies
     *
     */
    public void fillAllInitialDependencies(HashSet currentDependencies, ArrayList<ArrayList> dependencies, ArrayList project, ArrayList path){
        HashSet dependentDependenciesSet = new HashSet();
        for(int i = 0 ; i<dependencies.size() ; i++){
            dependentDependenciesSet.add(dependencies.get(i).get(1));
        }
        for(int i = 0 ; i<project.size(); i++){
            if(!dependentDependenciesSet.contains(project.get(i))){
                currentDependencies.add(project.get(i));
                path.add(project.get(i));
            }
        }
    }


}
