package gg.dailymaple.member.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String account;

    @Column(unique = true)
    private String representativeCharacter;

    @Column(nullable = false, unique = true)
    private Long githubId;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    protected Member() {
    }

    public Member(String account, String representativeCharacter, Long githubId, String imageUrl) {
        this(null, account, representativeCharacter, githubId, imageUrl);
    }

    public Member(Long id, String account, String representativeCharacter, Long githubId, String imageUrl) {
        this.id = id;
        this.account = account;
        this.representativeCharacter = representativeCharacter;
        this.githubId = githubId;
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
