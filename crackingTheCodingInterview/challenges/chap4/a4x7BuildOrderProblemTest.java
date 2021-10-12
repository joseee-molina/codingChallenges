package chap4;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class a4x7BuildOrderProblemTest extends a4x7BuildOrderProblem {
    @Test
    public void testBuildOrder(){
        ArrayList project = new ArrayList();
        ArrayList<ArrayList> dependencies = new ArrayList<>();
        project.add('a');
        project.add('b');
        project.add('c');
        project.add('d');
        project.add('e');
        project.add('f');
        ArrayList dep1 = new ArrayList();
        dep1.add('a');
        dep1.add('d');
        ArrayList dep2 = new ArrayList();
        dep2.add('f');
        dep2.add('b');
        ArrayList dep3 = new ArrayList();
        dep3.add('b');
        dep3.add('d');
        ArrayList dep4 = new ArrayList();
        dep4.add('f');
        dep4.add('a');
        ArrayList dep5 = new ArrayList();
        dep5.add('d');
        dep5.add('c');
        dependencies.add(dep1);
        dependencies.add(dep2);
        dependencies.add(dep3);
        dependencies.add(dep4);
        dependencies.add(dep5);
        System.out.println(buildOrder(dependencies,project).toString());
    }
}