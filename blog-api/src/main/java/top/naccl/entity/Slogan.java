package top.naccl.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

/**
 * @Description:
 * @Author: WainZeng
 * @Date: 2024/9/27 14:28
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Slogan {
    private Long id;
    private String content;
}
