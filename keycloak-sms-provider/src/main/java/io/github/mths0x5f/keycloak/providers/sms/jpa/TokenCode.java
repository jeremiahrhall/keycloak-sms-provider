package io.github.mths0x5f.keycloak.providers.sms.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "PHONE_MESSAGE_TOKEN_CODE")
@NamedQueries({
        @NamedQuery(
                name = "ongoingProcess",
                query = "FROM TokenCode t WHERE t.realmId = :realmId " +
                        "AND t.phoneNumber = :phoneNumber " +
                        "AND t.expiresAt >= :now AND t.type = :type"
        ),
})
public class TokenCode {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "REALM_ID", nullable = false)
    private String realmId;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Column(name = "TYPE", nullable = false)
    private String type;

    @Column(name = "CODE", nullable = false)
    private String code;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", nullable = false)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXPIRES_AT", nullable = false)
    private Date expiresAt;

    @Column(name = "CONFIRMED", nullable = false)
    private Boolean confirmed;
}
