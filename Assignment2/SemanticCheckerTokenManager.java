/* Generated By:JavaCC: Do not edit this line. SemanticCheckerTokenManager.java */

/** Token Manager. */
public class SemanticCheckerTokenManager implements SemanticCheckerConstants
{

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x2000000040L) != 0L)
            return 0;
         if ((active0 & 0x40000001fffe000L) != 0L)
         {
            jjmatchedKind = 11;
            return 27;
         }
         return -1;
      case 1:
         if ((active0 & 0x40000001fffe000L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 1;
            return 28;
         }
         return -1;
      case 2:
         if ((active0 & 0x40000001fefe000L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 2;
            return 28;
         }
         return -1;
      case 3:
         if ((active0 & 0x40000001bcfe000L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 3;
            return 28;
         }
         return -1;
      case 4:
         if ((active0 & 0x40000001949e000L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 4;
            return 28;
         }
         return -1;
      case 5:
         if ((active0 & 0x400000019418000L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 5;
            return 28;
         }
         return -1;
      case 6:
         if ((active0 & 0x400000018010000L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 6;
            return 28;
         }
         return -1;
      case 7:
         if ((active0 & 0x400000010010000L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 7;
            return 28;
         }
         return -1;
      case 8:
         if ((active0 & 0x400000000010000L) != 0L)
         {
            jjmatchedKind = 11;
            jjmatchedPos = 8;
            return 28;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x10000000000L);
      case 37:
         return jjStopAtPos(0, 38);
      case 38:
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 40:
         return jjStopAtPos(0, 51);
      case 41:
         return jjStopAtPos(0, 52);
      case 42:
         return jjStopAtPos(0, 36);
      case 43:
         jjmatchedKind = 34;
         return jjMoveStringLiteralDfa1_0(0x800000000000L);
      case 44:
         return jjStopAtPos(0, 57);
      case 45:
         jjmatchedKind = 35;
         return jjMoveStringLiteralDfa1_0(0x1000000000000L);
      case 46:
         return jjStopAtPos(0, 50);
      case 47:
         jjmatchedKind = 37;
         return jjMoveStringLiteralDfa1_0(0x40L);
      case 59:
         return jjStopAtPos(0, 49);
      case 60:
         jjmatchedKind = 43;
         return jjMoveStringLiteralDfa1_0(0x100000000000L);
      case 61:
         jjmatchedKind = 33;
         return jjMoveStringLiteralDfa1_0(0x8000000000L);
      case 62:
         jjmatchedKind = 41;
         return jjMoveStringLiteralDfa1_0(0x40000000000L);
      case 91:
         return jjStopAtPos(0, 53);
      case 93:
         return jjStopAtPos(0, 54);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x4000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x10080000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x8060000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x4000000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x400000000110000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x200000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x400000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x1800000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0xa000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x2000000L);
      case 123:
         return jjStopAtPos(0, 55);
      case 124:
         return jjMoveStringLiteralDfa1_0(0x400000000000L);
      case 125:
         return jjStopAtPos(0, 56);
      default :
         return jjMoveNfa_0(2, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x200000000000L) != 0L)
            return jjStopAtPos(1, 45);
         break;
      case 42:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      case 43:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStopAtPos(1, 47);
         break;
      case 45:
         if ((active0 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 48);
         break;
      case 61:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStopAtPos(1, 39);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStopAtPos(1, 40);
         else if ((active0 & 0x40000000000L) != 0L)
            return jjStopAtPos(1, 42);
         else if ((active0 & 0x100000000000L) != 0L)
            return jjStopAtPos(1, 44);
         break;
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x1a00000L);
      case 102:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(1, 11, 28);
         break;
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x40000L);
      case 109:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000000000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x30000L);
      case 111:
         return jjMoveStringLiteralDfa2_0(active0, 0x16080000L);
      case 114:
         return jjMoveStringLiteralDfa2_0(active0, 0x404000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0xa000L);
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000L);
      case 124:
         if ((active0 & 0x400000000000L) != 0L)
            return jjStopAtPos(1, 46);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x802000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x2400000L);
      case 110:
         return jjMoveStringLiteralDfa3_0(active0, 0x10080000L);
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000000000L);
      case 114:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(2, 11, 28);
         return jjMoveStringLiteralDfa3_0(active0, 0x8000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x40000L);
      case 116:
         return jjMoveStringLiteralDfa3_0(active0, 0x9010000L);
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000L);
      case 119:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(2, 11, 28);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0);
}
private int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000L);
      case 100:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 28);
         else if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 28);
         break;
      case 101:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 28);
         return jjMoveStringLiteralDfa4_0(active0, 0x8010000L);
      case 108:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000000000L);
      case 109:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(3, 11, 28);
         break;
      case 110:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000L);
      case 114:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0x1008000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0);
}
private int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0);
      return 4;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000L);
      case 101:
         return jjMoveStringLiteralDfa5_0(active0, 0x400000000000000L);
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x10000000L);
      case 107:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(4, 11, 28);
         break;
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x1010000L);
      case 116:
         if ((active0 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(4, 11, 28);
         else if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(4, 11, 28);
         return jjMoveStringLiteralDfa5_0(active0, 0x400000L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0);
}
private int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0);
      return 5;
   }
   switch(curChar)
   {
      case 100:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000L);
      case 102:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(5, 11, 28);
         return jjMoveStringLiteralDfa6_0(active0, 0x10000L);
      case 109:
         return jjMoveStringLiteralDfa6_0(active0, 0x400000000000000L);
      case 110:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(5, 11, 28);
         return jjMoveStringLiteralDfa6_0(active0, 0x10000000L);
      case 116:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(5, 11, 28);
         break;
      default :
         break;
   }
   return jjStartNfa_0(4, active0);
}
private int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0);
      return 6;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000L);
      case 101:
         return jjMoveStringLiteralDfa7_0(active0, 0x400000000000000L);
      case 115:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(6, 11, 28);
         break;
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000000L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0);
}
private int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0);
      return 7;
   }
   switch(curChar)
   {
      case 99:
         return jjMoveStringLiteralDfa8_0(active0, 0x10000L);
      case 101:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(7, 11, 28);
         break;
      case 110:
         return jjMoveStringLiteralDfa8_0(active0, 0x400000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0);
}
private int jjMoveStringLiteralDfa8_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(6, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0);
      return 8;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(8, 11, 28);
         break;
      case 116:
         return jjMoveStringLiteralDfa9_0(active0, 0x400000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0);
}
private int jjMoveStringLiteralDfa9_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(7, old0);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0);
      return 9;
   }
   switch(curChar)
   {
      case 115:
         if ((active0 & 0x400000000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 11, 28);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0);
}
private int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 27;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 28:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAddStates(0, 2);
                  }
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 12)
                        kind = 12;
                     jjCheckNAdd(22);
                  }
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAddStates(0, 2);
                  }
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 12)
                        kind = 12;
                     jjCheckNAdd(22);
                  }
                  break;
               case 2:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 10)
                        kind = 10;
                     jjCheckNAddTwoStates(17, 18);
                  }
                  else if (curChar == 39)
                     jjCheckNAddStates(3, 6);
                  else if (curChar == 47)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 0:
                  if (curChar != 47)
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjCheckNAdd(1);
                  break;
               case 1:
                  if ((0xffffffffffffdbffL & l) == 0L)
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjCheckNAdd(1);
                  break;
               case 11:
                  if (curChar == 39)
                     jjCheckNAddStates(3, 6);
                  break;
               case 12:
                  if ((0xffffffff00000000L & l) != 0L)
                     jjCheckNAddTwoStates(12, 13);
                  break;
               case 13:
                  if (curChar == 39 && kind > 9)
                     kind = 9;
                  break;
               case 14:
                  if ((0xffffffff00000000L & l) != 0L)
                     jjCheckNAddTwoStates(14, 15);
                  break;
               case 15:
                  if (curChar == 39 && kind > 31)
                     kind = 31;
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  jjCheckNAddTwoStates(17, 18);
                  break;
               case 17:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  jjCheckNAdd(17);
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 30)
                     kind = 30;
                  jjCheckNAddTwoStates(19, 18);
                  break;
               case 19:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 30)
                     kind = 30;
                  jjCheckNAdd(19);
                  break;
               case 22:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(22);
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAddStates(0, 2);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 28:
                  if ((0x7fffffe00000000L & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAddStates(7, 10);
                  }
                  else if (curChar == 95)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAddStates(0, 2);
                  }
                  if ((0x7fffffe00000000L & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAddStates(11, 13);
                  }
                  if ((0x7fffffe00000000L & l) != 0L)
                  {
                     if (kind > 12)
                        kind = 12;
                     jjCheckNAdd(22);
                  }
                  if ((0x7fffffe00000000L & l) != 0L)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAdd(21);
                  }
                  break;
               case 27:
                  if ((0x7fffffe00000000L & l) != 0L)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAddStates(7, 10);
                  }
                  else if (curChar == 95)
                  {
                     if (kind > 29)
                        kind = 29;
                     jjCheckNAddStates(0, 2);
                  }
                  if ((0x7fffffe00000000L & l) != 0L)
                  {
                     if (kind > 12)
                        kind = 12;
                     jjCheckNAdd(22);
                  }
                  if ((0x7fffffe00000000L & l) != 0L)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAdd(21);
                  }
                  break;
               case 2:
                  if ((0x7fffffe00000000L & l) != 0L)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAddStates(14, 18);
                  }
                  else if (curChar == 70)
                     jjstateSet[jjnewStateCnt++] = 9;
                  else if (curChar == 84)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 1:
                  if (kind > 5)
                     kind = 5;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 3:
                  if (curChar == 101 && kind > 32)
                     kind = 32;
                  break;
               case 4:
                  if (curChar == 117)
                     jjCheckNAdd(3);
                  break;
               case 5:
                  if (curChar == 114)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 6:
                  if (curChar == 84)
                     jjstateSet[jjnewStateCnt++] = 5;
                  break;
               case 7:
                  if (curChar == 115)
                     jjCheckNAdd(3);
                  break;
               case 8:
                  if (curChar == 108)
                     jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 9:
                  if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 10:
                  if (curChar == 70)
                     jjstateSet[jjnewStateCnt++] = 9;
                  break;
               case 12:
                  if ((0x7fffffffffffffffL & l) != 0L)
                     jjAddStates(19, 20);
                  break;
               case 14:
                  if ((0x7fffffffffffffffL & l) != 0L)
                     jjAddStates(21, 22);
                  break;
               case 20:
                  if ((0x7fffffe00000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddStates(14, 18);
                  break;
               case 21:
                  if ((0x7fffffe00000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(21);
                  break;
               case 22:
                  if ((0x7fffffe00000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(22);
                  break;
               case 24:
                  if ((0x7fffffe00000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAddStates(11, 13);
                  break;
               case 25:
                  if (curChar != 95)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAddStates(0, 2);
                  break;
               case 26:
                  if ((0x7fffffe00000000L & l) == 0L)
                     break;
                  if (kind > 29)
                     kind = 29;
                  jjCheckNAddStates(7, 10);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 1:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 5)
                     kind = 5;
                  jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 27 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private int jjMoveStringLiteralDfa0_1()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_1(0x80L);
      default :
         return 1;
   }
}
private int jjMoveStringLiteralDfa1_1(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 47:
         if ((active0 & 0x80L) != 0L)
            return jjStopAtPos(1, 7);
         break;
      default :
         return 2;
   }
   return 2;
}
static final int[] jjnextStates = {
   24, 23, 25, 12, 13, 14, 15, 23, 25, 24, 26, 23, 25, 24, 21, 22, 
   23, 25, 26, 12, 13, 14, 15, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
"\163\164\141\162\164", "\142\162\145\141\153", "\163\164\162\165\143\164", 
"\151\156\164\145\162\146\141\143\145", "\145\156\165\155", "\145\154\163\145", "\143\157\156\163\164", "\151\146", 
"\156\145\167", "\160\162\151\156\164\146", "\162\145\141\144", "\162\145\164\165\162\156", 
"\166\157\151\144", "\146\157\162", "\145\170\164\145\156\144\163", 
"\143\157\156\164\151\156\165\145", null, null, null, null, "\75", "\53", "\55", "\52", "\57", "\45", "\75\75", 
"\41\75", "\76", "\76\75", "\74", "\74\75", "\46\46", "\174\174", "\53\53", "\55\55", 
"\73", "\56", "\50", "\51", "\133", "\135", "\173", "\175", "\54", 
"\151\155\160\154\145\155\145\156\164\163", };

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
   "ML_COMMENT_STATE",
};

/** Lex State array. */
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, 1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0x7fffffffffffe01L, 
};
static final long[] jjtoSkip = {
   0x1feL, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[27];
private final int[] jjstateSet = new int[54];
protected char curChar;
/** Constructor. */
public SemanticCheckerTokenManager(SimpleCharStream stream){
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}

/** Constructor. */
public SemanticCheckerTokenManager(SimpleCharStream stream, int lexState){
   this(stream);
   SwitchTo(lexState);
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 27; i-- > 0;)
      jjrounds[i] = 0x80000000;
}

/** Reinitialise parser. */
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}

/** Switch to specified lex state. */
public void SwitchTo(int lexState)
{
   if (lexState >= 2 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(java.io.IOException e)
   {
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   switch(curLexState)
   {
     case 0:
       try { input_stream.backup(0);
          while (curChar <= 32 && (0x100002600L & (1L << curChar)) != 0L)
             curChar = input_stream.BeginToken();
       }
       catch (java.io.IOException e1) { continue EOFLoop; }
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_0();
       break;
     case 1:
       jjmatchedKind = 0x7fffffff;
       jjmatchedPos = 0;
       curPos = jjMoveStringLiteralDfa0_1();
       if (jjmatchedPos == 0 && jjmatchedKind > 8)
       {
          jjmatchedKind = 8;
       }
       break;
   }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else
        {
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

}
