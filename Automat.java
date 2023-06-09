//individual enam files
public enum State {Success,Error,Q1,Q2,Q3,Q4,Initial}
public enum Event {Digit, Sharp, Percent, Multiplication, UpperLetter, EOS, ANY}
//class Automat
public class Automat extends FSM {
    private Event event;

    public Automat(String text) {
        super(text);
    }

    public State getState() {
        return state;
    }

    @Override
    public boolean scanner() {
        int count =0;

        do{
            if(count<this.text.length())
            {
                event = recognizeEvent(text.charAt(count));
            }
            else {
                event=Event.EOS;
            }
            handleEvent(event);
            count++;
        }
        while(state!=State.Success&&state!=State.Error);

        if(state==State.Success)
        {
            return true;
        }else
            return false;
    }
    public Event recognizeEvent(char ch) {

        Event temp;
        switch (ch) {

            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':

                temp = Event.UpperLetter;
                break;

            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                temp = Event.Digit;
                break;

            case '#':
                temp = Event.Sharp;
                break;

            case '%':
                temp = Event.Percent;
                break;

            case '*':
                temp = Event.Multiplication;
                break;

            default:
                temp = Event.ANY;
        }
        return temp;
    }
    @Override

    public void handleEvent(Event event) {
        switch (state) {
            case Initial:
                switch (event){
                    case Digit:
                        state=State.Q1;
                         break;
                    case EOS:
                        state=State.Error;
                        break;
                    default:
                        state = State.Error;
                        break;
                }
                break;

            case Q1:
                switch (event){
                    case Digit:
                        state=State.Q1;
                        break;
                    case Multiplication:
                        state=State.Q2;
                        break;
                    case Percent:
                        state=State.Q2;
                        break;

                    case UpperLetter:
                        state=State.Q3;
                        break;

                    case EOS:
                        state=State.Error;
                        break;

                    default:
                        state = State.Error;
                        break;
                }
                break;

            case Q2:
                switch (event){
                    case Sharp:
                        state=State.Q4;
                        break;
                    case EOS:
                        state=State.Error;
                        break;
                    default:
                        state=State.Error;
                        break;
                }
                break;

            case Q3:
                switch (event){
                    case UpperLetter:
                        state=State.Q3;
                        break;

                    case Sharp:
                        state=State.Q4;
                        break;

                    case EOS:
                        state=State.Error;
                        break;

                    default:
                        state=State.Error;
                        break;
                }
                break;

            case Q4:
                switch (event)
                {
                    case EOS:
                        state=State.Success;
                        break;
                    default:
                        state=State.Error;
                        break;
                }
                break;

        }
    }
}
