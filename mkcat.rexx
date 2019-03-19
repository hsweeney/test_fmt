/* rexx to build a catalog as a rexx stemmed array from zVSAM sourec eg TESTCAT.MLC */

true = (true=true); false = \true
parse upper arg catSrc

bufRec = ''
stmtRec = ''

say '{'getStmt()'}'
return 0





getStmt:    /* Return the next assembly statement */
            /* Exclude comments and directives. Join up multiple continuation recs. */

continued = false    /* Current rec is continued on next. */

do forever
  if bufRec = '' then bufRec = linein(catSrc)
  if bufRec = ' ' then do; bufRec=''; iterate; end
  if left(bufRec, 1) = '*' then do; bufRec=''; iterate; end
  if substr(bufrec, 72, 1) \= ' ' then do; continued = true;
  bufRec = left(bufRec, 71)
  if left(bufRec, 1) \= ' ' then parse var bufRec . bufRec
  bufRec = strip(bufRec)
  parse var bufRec operation operands
  if operation = 'END' then exit 0
  say '['bufRec']'; bufrec = ''
end

return stmtRec
