### Stack implementations

##### Algorithm complexity the worst case
| implementation | push  | peek | pop  | size |
| -------------- | ----- | ---- | ---- | ---- |
| ArrayStack     | 0(1)* | O(1) | O(1) | O(1) |
| LinkedStack    | O(1)  | O(1) | O(1) | O(1) |

 \* amortized if ArrayStack should resize, but very rarely happens. 

### Queue implementations

##### Algorithm complexity the worst case
| implementation | push  | peek | poll | size |
| -------------- | ----- | ---- | ---- | ---- |
| LinkedQueue    | 0(1)  | O(1) | O(1) | O(1) |

