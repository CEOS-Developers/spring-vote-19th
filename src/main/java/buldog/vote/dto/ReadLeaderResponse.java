package buldog.vote.dto;

import buldog.vote.domain.Part;
import buldog.vote.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class ReadLeaderResponse {
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Part part;

    private int voteCount;

    public static ReadLeaderResponse from(User user, int voteCount) {
        ReadLeaderResponse response = new ReadLeaderResponse();
        response.name = user.getName();
        response.part = user.getPart();
        response.voteCount = voteCount;

        return response;
    }
}
