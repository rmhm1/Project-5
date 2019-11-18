package prj5;

/**
 * Compiles the various enums with getters
 * 
 * @author ryland
 * @version 2019.11.18
 */
public class Attributes {

    private MajorEnum major;
    private HobbyEnum hobby;
    private RegionEnum region;


    /**
     * Creates the attribute with the assigned enums
     * 
     * @param major
     *            the MajorEnum
     * @param hobby
     *            the HobbyEnum
     * @param region
     *            the RegionEnum
     */
    public Attributes(MajorEnum major, HobbyEnum hobby, RegionEnum region) {
        this.major = major;
        this.hobby = hobby;
        this.region = region;
    }


    /**
     * Getter for MajorEnum
     * 
     * @return the MajorEnum
     */
    public MajorEnum getMajor() {
        return major;
    }


    /**
     * Getter for HobbyEnum
     * 
     * @return the HobbyEnum
     */
    public HobbyEnum getHobby() {
        return hobby;
    }


    /**
     * Getter for RegionEnum
     * 
     * @return the RegionEnum
     */
    public RegionEnum getRegion() {
        return region;
    }
}
