/* -------------------------------------------------------------------------- *\
 |                                                                            |
 |  Access Control Block                                                      |
 |                                                                            |
\* -------------------------------------------------------------------------- */

/**
 * A Java object that shadows an ACB that is in emulator memory.
 * 
 * This object is created on execution of the Open SVC. It is built from the ACB
 * in e-memory that is passed with the SVC.
 * 
 * @author  Hugh Sweeney
 * 
 */
public class ACB {
   private int mACB;   // address of ACB in mem_byte
   private FCB theFCB;
   // !! all members private except those that need otherwise.
   // !! keep a copy of all mACB fields here, or access as needed?
   // !! See IFGACB



/**
 * Populates the ACB from the e-memory contents.
 * 
 * @param   mem      int pointing to a memory location that should be an ACB.
 * 
 */
   public ACB(mem) {
      //!! store time?
   }



/**
 * Accesses the ddname->file, reads, and verifies the Prefix block.
 *
 *
 */
   public int open() {
      // called from constructor?
   }

}               







/* -------------------------------------------------------------------------- *\
 |                                                                            |
 |  File Control Block                                                        |
 |                                                                            |
\* -------------------------------------------------------------------------- */

/**
 * A Java object that maintains state for a File Control Block
 * 
 * 
 * @author  Hugh Sweeney
 * 
 */
public class FCB {

  LinkedList data_blocks;

  PFX_buffer pfx;
  File the_file;        //!! what is this?
  Buffer index_root;    //!! whhat kind of buffer is this?
  List<Buffer> index_buffers;    //!! likewise

  /**
  Constructor
  */
  public FCB(acb) {
    //!! copy attributes from ACB
  }


  /**
  Opens the physical file
  */
  public open() {
/*!! From zVSAM_design.ods
Buffer create(4K)
Set ptr to PFX-buffer
pfx.create(file handle, PFX-buffer)
Set ptr to PFX
pfx.validate
check pfx against catalog entry
pfx.get_index_level
Allocate data buffers
Set ptr to Data buffer chain
Allocate index buffers
Set ptr to index buffer chains
open associated index component
open base index component
open base data component
*/
  }


  /**
  Closes the physical file
  */
  public close() {
/*!! From zVSAM_design.ods
close base data component
close base index component
close associated index component
Buffer.flush_buffers
Buffer.free_buffers
update_pfx
pfx_buffer.flush_buffer
pfx_buffer.free_buffer
Close physical file
*/
  }


  /**
  Reads the PFX
  */
  public read_pfx() {
  }


  /**
  Validates the PFX
  */
  public validate_pfx() {
  }


  /**
  Flushes all the buffers
  */
  public flush-buffers() {
  }


  /**
  Frees the buffers
  */
  public free_buffers() {
  }


  /**
  Updates the PFX
  */
  public update_pfx() {
  }

















}







/* -------------------------------------------------------------------------- *\
 |                                                                            |
 |  Buffer                                                                    |
 |                                                                            |
\* -------------------------------------------------------------------------- */

/**
 * I/O data for an FCB.                                     
 * 
 * 
 * @author  Hugh Sweeney
 * 
 */
public class zBuffer {

  static LinkedList bufferList = new LinkedList()

  byte[] data;           //!! size=BLKSIZE

  Buffer prev;           //!! Do we need these? Or let LinkedList methods deal with it?
  Buffer next;           //!!   "

  long XLRA;
  boolean modified;


  /**
  Constructor
  */
  public zBuffer(blkSize) {
    data = new ByteArray(blksize);    //!! ? is this the best way?
    bufferList.add(this);
  }


  /**
  Flushes the buffer
  */
  public flush() { 
    if (modified) { 
      //!! write it
      modified = false;
    }
  }


  /**
  Frees the buffer
  */
  public free() { 
    if (modified) throw(new RuntimeException("Attempt to free a modified buffer!!")); 
    bufferList.remove(this)
    // !! Don't forget: caller must nullify its reference to the buffer.
  }

// end of class
}







/* -------------------------------------------------------------------------- *\
 |                                                                            |
 |  Request Parameter List                                                    |
 |                                                                            |
\* -------------------------------------------------------------------------- */

/**
 * A Java object that shadows an RPL in emulator memory.
 * 
 * This object is created on issuance of a request against an ACB.
 * 
 * @author  Hugh Sweeney
 * 
 */
public class RPL {
}
