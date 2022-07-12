
class Node {
    constructor(index) {
      this.index = index;
      this.prev = null;
      this.next = null;
    }
  }
  
  function solution(n, k, cmd) {
      let select;
      let prevNode = new Node(0);
      for(let i = 1; i<n; i++){
          const node =new Node(i);
          node.prev = prevNode;
          prevNode.next = node;
          prevNode = node;
          if(i === k) select = node;
      }
      
      let stack =[];
      
      const move = (count ,  direct) =>{
          for(let i = 0; i < count; i++){
              if(!select[direct]) break;
              select = select[direct];
          }
      }
      
      const deleteNode = ()=>{
          // stack.push(select);
          
  //         const prev = select.prev;
  //         const next = select.next;
  //         select = next ? next :  prev;
          
  //         if(prev) prev.next = next;
  //         if(next) next.prev = prev;
          
          stack.push(select);
          if(select.next){
              if(select.prev) select.prev.next = select.next;
              select.next.prev = select.prev;
              select = select.next;
              
          }else{
              if(select.prev) select.prev.next = null;
              select = select.prev;
          }
      }
      
      const recover = () =>{
          const node = stack.pop();
          
          if(node.prev) {
              node.prev.next = node;
          }
          if(node.next){
              node.next.prev = node;
          }
      }
      
      for(let i =0; i< cmd.length; i++){
          let [command, cnt] = cmd[i].split(" ");
          switch(command){
              case "U" :
                  move(cnt, "prev");
                  break;
              case "D" :
                  move(cnt, "next");
                  break;
              case "C" :
                  deleteNode();
                  break;
              case "Z" :
                  recover();
                  break;
          }
      }
      
      let answer = new Array(n).fill("O");
      stack.forEach(node => answer[node.index] = "X");
      return answer.join("");
  }