package commandProvider;

import spaceMarines.SpaceMarine;
import java.util.Comparator;

public class CompareSpaceMarine implements Comparator<SpaceMarine> {
    /**
     * Мой компаратор который сортирует по имени
     * @param sp1 the first object to be compared.
     * @param sp2 the second object to be compared.
     * @return int
     */
    @Override
    public int compare(SpaceMarine sp1, SpaceMarine sp2){
        return sp1.getName().length() - sp2.getName().length();
    }
}
