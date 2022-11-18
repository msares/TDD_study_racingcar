package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationUtilsTest {

    @Test
    @DisplayName("입력받은_자동차이름_1자이상_5자이하_검증")
    void 입력받은_자동차이름_1자이상_5자이하_검증() {
        assertThat(ValidationUtils.validateCarName("S")).isEqualTo("S");
        assertThat(ValidationUtils.validateCarName("SSONG")).isEqualTo("SSONG");
    }
    @Test
    @DisplayName("입력받은_자동차이름_null값_에러검증")
    void 입력받은_자동차이름_null값_에러검증() {
        assertThatThrownBy(() -> ValidationUtils.validateCarName(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
    @Test
    @DisplayName("입력받은_자동차이름_5자초과_에러검증")
    void 입력받은_자동차이름_5자초과_에러검증() {
        assertThatThrownBy(() -> ValidationUtils.validateCarName("SONGSUJUNG"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("[ERROR]");
    }
}
