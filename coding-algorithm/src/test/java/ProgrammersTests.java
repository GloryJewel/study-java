import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ProgrammersTests {

    @Test
    void supoja(){

        int[] answers = {1, 3, 2, 4, 2};

        final int[] human1Array = {1, 2, 3, 4, 5};
        final int[] human2Array = {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] human3Array = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        Human[] humans = new Human[3];

        humans[0] = new Human(1, human1Array);
        humans[1] = new Human(2, human2Array);
        humans[2] = new Human(3, human3Array);

        for(int answer :answers){

            humans[0].check(answer);
            humans[1].check(answer);
            humans[2].check(answer);
        }

        final int max = Math.max(Math.max(humans[0].getCount(),humans[1].getCount()),humans[2].getCount());

        int[] result = Arrays.stream(humans)
                .filter(x -> max == x.getCount())
                .mapToInt(x -> x.id).toArray();

        System.out.println(Arrays.toString(result));
    }

    class Human{

        public int id;
        private int[] paper;
        private int paperIndex=0;
        public int count=0;

        Human(int id, int[] paper){
            this.id = id;
            this.paper = paper;
        }

        public void check(int dap){
            if( paperIndex == paper.length)
                paperIndex=0;

            if(paper[paperIndex] == dap)
                count++;

            paperIndex++;
        }

        public int getCount(){
            return this.count;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }



}
