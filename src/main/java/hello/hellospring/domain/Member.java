package hello.hellospring.domain;

public class Member {

    private Long id; // 데이터를 구별하기위한 시스템이 저장하는 임의값
    private String name; //이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
