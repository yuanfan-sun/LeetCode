package AddTwoNumbers;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*int moreThanTen = 0;
        ListNode result = new ListNode();
        ListNode temp = result;
        while (l1 != null && l2 != null) {
            if (l1.val + l2.val + moreThanTen < 10) {
                temp.val = l1.val + l2.val + moreThanTen;
                moreThanTen = 0;
            } else {
                temp.val = (l1.val + l2.val) % 10 + moreThanTen;
                moreThanTen = 1;
            }
            if (l1.next != null || l2.next != null) {
                temp = temp.next = new ListNode();
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {
            l1 = l2;
        }

        while (l1 != null) {
            if (l1.val == 9 && moreThanTen == 1) {
                temp = temp.next = new ListNode(0);
                l1 = l1.next;
                if(l1 == null){
                    temp.next = new ListNode(1);
                    break;
                }
            }

        }
        return result;*/
        ListNode head = new ListNode();
        return recursiveHelpMethode(l1, l2, 0, head);
    }

    ListNode recursiveHelpMethode(ListNode l1, ListNode l2, int moreThanTen, ListNode result) {
        //把temp挂到result后面
        ListNode temp = result;
        //如果l1 l2都为空则退出
        if (l1 == null && l2 == null) {
            result=null;
            return result;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        if (l1.val + l2.val + moreThanTen < 10) {
            temp.val = l1.val + l2.val + moreThanTen;
            moreThanTen = 0;
        } else if (l1.val + l2.val + moreThanTen >= 10 && l1.next == null) {
            if (l2.next == null) {
                temp.val = (l1.val + l2.val + moreThanTen) % 10;
                temp.next = new ListNode(1);
                return result;
            } else {
                temp.val = (l1.val + l2.val + moreThanTen) % 10;
                moreThanTen = 1;
            }
        } else {
            temp.val = (l1.val + l2.val + moreThanTen) % 10;
            moreThanTen = 1;
        }

        temp.next = recursiveHelpMethode(l1.next, l2.next, moreThanTen, new ListNode());
        return result;
    }
}