package org.redeyefrog.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "SSO_TOKEN", schema = "REFROG")
public class SsoTokenEntity {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "KIND")
    private String kind;

    @Column(name = "PARAMS")
    private String params;

    @Column(name = "USE_STATUS")
    private String useStatus;

    @Column(name = "CREATE_TIME")
    private LocalDateTime createTime;

}
