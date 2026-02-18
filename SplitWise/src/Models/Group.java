package Models;

import java.util.List;

public class Group {

    private int groupId;
    private String name;
    private String description;
    private List<User> members;

    public Group(int groupId, String name, String description, List<User> members) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.members = members;
    }

    public int getGroupId() {
        return groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public void addMembers(List<User> members)
    {
        this.members.addAll(members);
    }
}
