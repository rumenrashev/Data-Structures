# java-data-structures-custom-implementation

### Stack implementations

##### Algorithm complexity the worst case
| implementation | push  | peek | pop  | size |
| -------------- | ----- | ---- | ---- | ---- |
| ArrayStack     | 0(1)* | O(1) | O(1) | O(1) |
| LinkedStack    | O(1)  | O(1) | O(1) | O(1) |

 \* amortized if ArrayStack should resize, but very rarely happens. 

##### Time in milliseconds for to push and pop 1 million elements , performed on my machine
| implementation |  time in milliseconds |
| ---------------| --------------------- | 
| ArrayStack     | 30-50                 | 
| LinkedStack    | 140-170               | 

##### Conclusion : ArrayStack is around 3 times faster than LinkedStack.
