package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.Controller.RacingController;
import racingcar.Model.RacingUser;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    RacingController racingController = new RacingController();


    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 전진_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 이름에_대한_예외_처리2() {
        assertSimpleTest(
                () -> {
                    runException("pobi,,java");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 이름에_대한_예외_처리3() {
        assertSimpleTest(
                () -> {
                    runException("pobi,,java,pobi");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 게임사이즈에_대한_예외_처리1() {
        assertSimpleTest(
                () -> {
                    runException("pobi,java,pobi","abc");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 게임사이즈에_대한_예외_처리2() {
        assertSimpleTest(
                () -> {
                    runException("pobi,java,pobi","10000");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 이름_리스트_체크()
    {
        assertSimpleTest(
                () -> {
                    run("pobi,java,kuro","5");
                    ArrayList<RacingUser> userList = Application.getControllerUserList();
                    int result = Application.getControllerUserList().size();
                    AssertionsForClassTypes.assertThat(result).isEqualTo(3);
                    AssertionsForClassTypes.assertThat(userList.get(0).getName()).isEqualTo("pobi");
                    AssertionsForClassTypes.assertThat(userList.get(1).getName()).isEqualTo("java");
                    AssertionsForClassTypes.assertThat(userList.get(2).getName()).isEqualTo("kuro");
                }
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
