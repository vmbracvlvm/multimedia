DESCRIPTION = "Speex is an Open Source/Free Software patent-free audio compression format designed for speech."
HOMEPAGE = "http://www.speex.org"
SECTION = "libs"
LICENSE = "BSD"
DEPENDS = "libogg-dev \
           ${TARGET_ARCH}/sysroot-libm"

SRC_URI = "http://downloads.us.xiph.org/releases/speex/speex-1.2rc1.tar.gz"

#PARALLEL_MAKE = ""

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-fixed-point --with-ogg-libraries=${STAGE_DIR}/sysroot/usr/lib \
                 --disable-float-api --disable-vbr \
                 --with-ogg-includes=${STAGE_DIR}/sysroot/usr/include --disable-oggtest"

PACKAGES += "${PN}-bin"

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${libdir}/lib*.so.*"
FILES_${PN}-bin = "${bindir}"