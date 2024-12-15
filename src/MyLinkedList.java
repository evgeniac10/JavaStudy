
import java.util.List;
import java.util.NoSuchElementException;

class Node<E>{
    E data;
    Node<E> next;

    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}
public class MyLinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size=0;
    }

    public Node<E> search(int index){
        if(index<0 || index>=size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> x = head;
        //찾고자 하는 노드의 인덱스 번호까지
        for(int i=0; i<index; i++){
            x = x.next;
        }
        return x;
    }

    public void addFirst(E value){
        Node<E> newNode = new Node<E>(value);
        //새로 생긴 노드의 다음 노드를 현재 head노드에 연결하기, 원래 있던 head앞에 새로운 노드가 끼어들었으니 이제 부터 head가 newNode가 됨.
        newNode.next = head;
        head = newNode;
        //노드가 한개 더 증가하였으니 그만큼 연결리스트 사이즈도 늘어난다.
        size++;

        //새로운 노드 기준으로 다음 연결할 노드가 없다 == 뒤에 노드가 없어 head이자 tail이 된다.
        if(head.next == null){
            tail = newNode;
        }
    }

    @Override
    public boolean add(E value) {
        //List 인터페이스의 메서드 오바라이드
        addLast(value);
        return false;
    }


    @Override
    public void add(int index, E element) {
        //우선 넣으려는 인덱스가 올바른지 검사
        if(index >= size || index <0){
            throw new IndexOutOfBoundsException;
        }
        //만약 가장 앞에 추가하려 하거나 가장 뒤에 추가하려 한다면
        if(index ==0){
            addFirst(element);
            return;
        }
        if(index == size){
            addLast(element);
            return;
        }

        Node<E> inputNode = new Node<>(element);
        //어디에 끼워 넣을지부터 찾고 중간에 노드를 끼워넣어 끼워놓으려는 노드 기준으로 전 노드(인덱스 번호는 0부터 시작이니 1을 뺀다)는 끼워드는 노드를 가리키고
        // 끼워드는 노드는 다음 노드를 가리킨다.
        Node<E> exNode = search(index-1);
        Node<E> postNode = search(index);
        //exNode.next =null; 참고사이트에서는 논리적인 이유 때문에 다음 가르키는 노드를 끊어야한다고 하지만 꼭 필요한건 아니다.
        exNode.next = inputNode;
        inputNode.next = postNode;
        size++;
    }

    //큐는 FIFO구조로 추가를 한다는 것은 가장 뒤로 들어가서 추가가 된다.
    public void addLast(E value){
        //어떠한 노드도 없는 경우에는 tail.next에서 NullPointException이 발생하니 링크드 리스트에 아무것도 없는지부터 검사한다.
        if(size ==0){
            addFirst(value);
            return;
        }
        Node<E> newNode = new Node<>(value);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    //제거하는 메서드로 FIFO 구조이기에 가장 앞 head부분을 제거한다.
    public E remove(){
        /*
        첫번째로 해야 할 일은 head부분의 노드를 꺼내오는 것이다.
        headNode가 없는 , 아무노드도 없는 경우는 예외처리해주기
        둘째로 원래 head부분에 있던 노드의 data는 return값으로 잘 제거되었는지 알려주고
        원래 head에 연결되었던 노드를 head로 만들어준다.
        만약 원래 노드가 1개였다가 remove로 제거되어 한 개도 없다면 head도 null이 될 것이고 tail도 null이 될 것이다.
         */
        Node<E> deleteNode = head;

        if(deleteNode == null){
            throw new NoSuchElementException();
        }
        E element = deleteNode.data;
        Node<E> nextNode = deleteNode.next;
        head = nextNode;
        size--;

        if(size == 0){
            tail = null;
        }
        return element;
    }
    //리스트의 인덱스 해당하는 노드를 제거한다.
    @Override
    public E remove(int index) {
        /*
        매개변수로 받은 인덱스 값이 0이라면 가장 첫번째 노드를 삭제한다고 하니 미리 구현해놓은 remove를 사용하면 되고
        매개변수로 받은 인덱스 값이 적절한 값이 아니라면 예외를 처리하고
        0번부터 시작하기에 구현해놓은 search메서드로 N번 인덱스의 노드를 지우고 싶다면 N-1번 노드를 찾은 뒤
        삭제 하려는 노드 기준으로 앞 노드가 뒤에 노드로 연결되도록 한다.
        만약 이전노드에 해당하는 exNode의 다음 exNode.next
        이 메서드 또한 삭제된 노드의 element를 반환하여 알려준다.
         */
        if(index == 0){
            return remove();
        }
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> exNode = search(index - 1);
        Node<E> deleteNode = exNode.next;
        Node<E> postNode = deleteNode.next;

        E element = deleteNode.data;
        exNode.next = postNode;

        //다음 노드가 없다면 tail은 exNode가 된다.
        if(exNode.next == null){
            tail = exNode;
        }
        /*
        명시적인 아래 코드를 작성하여 참조를 끊었다 라고 표현도 가능하면 GC의 메모리 회수에도 도움을 줄 수 있다.
        deleteNode.next = null;
        deleteNode.data = null;
         */
        size--;
        return element;
    }
    //data value 데이터 값을 검색하여 노드를 제거한다.
    @Override
    public boolean remove(Object value) {
        /*
        head부터 시작해서 매개변수로 받은 value가 리스트에 있는지를 확인한 뒤에
        있다면 지우려는 노드 delete 기준으로 앞 노드는 exNode 뒤에 노드는 delete.next가 다음 노드가 된다.
         */
        Node<E> exNode = head;
        boolean hasValue = false;
        Node<E> delete = head;

        for(;delete != null; delete=delete.next){
            if(value.equals(delete.data)){
                hasValue=true;
                break;
            }
            exNode=delete;//지우려는 노드 기준으로 이전 노드를 계속 저장해야 지우려는 노드의 다음을 연결 할 수 있음
        }
        if(delete == null){
            return false;
        }
        if(delete.equals(head)){
            remove();
            return true;
        }
        else{
            exNode.next = delete.next;
            if(exNode.next ==null){//다음노드를 가르키는 대상이 없다 ? -> 꼬리부분이다.
                tail = exNode;
            }
                    /*
        명시적인 아래 코드를 작성하여 참조를 끊었다 라고 표현도 가능하면 GC의 메모리 회수에도 도움을 줄 수 있다.
        deleteNode.next = null;
        deleteNode.data = null;
         */
            size--;
            return true;
        }
    }
}