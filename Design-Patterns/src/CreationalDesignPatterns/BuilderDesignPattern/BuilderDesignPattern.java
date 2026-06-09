package CreationalDesignPatterns.BuilderDesignPattern;

class User
{
    private final String name;
    private final int age;
    private final String email;
    private final String phone;

    private User(Builder builder)
    {
      this.name = builder.name;
      this.age = builder.age;
      this.email = builder.email;
      this.phone = builder.phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public static class Builder
    {
        private String name;
        private int age;
        private String email;
        private String phone;

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }
        public Builder age(int age)
        {
            this.age = age;
            return this;
        }
        public Builder email(String email)
        {
            this.email = email;
            return this;
        }
        public Builder phone(String phone)
        {
            this.phone = phone;
            return this;
        }

        public User build()
        {
            return  new User(this);
        }
    }
}
public class BuilderDesignPattern
{
  public static void main(String args[])
  {
      User user = new User.Builder().name("Akshay").age(22).email("akshay@gmail.com").build();
      String userDetails = user.toString();
      System.out.println(userDetails);
  }
}
