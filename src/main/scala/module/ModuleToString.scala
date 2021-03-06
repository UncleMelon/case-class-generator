package com.julianpeeters.caseclass.generator
import artisanal.pickle.maker._
import org.objectweb.asm._
import Opcodes._

case class ModuleToString(cw_MODULE: ClassWriter, var mv_MODULE: MethodVisitor, caseClassName: String) {
  def dump = {
    mv_MODULE = cw_MODULE.visitMethod(ACC_PUBLIC + ACC_FINAL, "toString", "()Ljava/lang/String;", null, null);
    mv_MODULE.visitCode();

    mv_MODULE.visitLdcInsn(caseClassName.split('/').last);
    mv_MODULE.visitInsn(ARETURN);
    mv_MODULE.visitMaxs(1, 1);
    mv_MODULE.visitEnd();
  }
}
