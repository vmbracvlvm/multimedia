DESCRIPTION = "Alsa sound library"
HOMEPAGE = "http://www.alsa-project.org"
BUGTRACKER = "https://bugtrack.alsa-project.org/alsa-bug/login_page.php"
LICENSE = "LGPLv2.1 & GPLv2+"

DEPENDS += "${TARGET_ARCH}/sysroot-libdl \
			${TARGET_ARCH}/sysroot-libpthread \
			${TARGET_ARCH}/sysroot-libm"

inherit autotools pkgconfig

SRC_URI = "ftp://ftp.alsa-project.org/pub/lib/alsa-lib-${PV}.tar.bz2"


EXTRA_OECONF = "--with-cards=pdaudiocf --with-oss=yes --disable-python"

PACKAGES =+ "${PN}-alsa-server ${PN}-libasound ${PN}-alsa-conf-base ${PN}-alsa-conf ${PN}-alsa-doc ${PN}-alsa-dev"

PROVIDES_${PN}-alsa-server = "alsa-server"
PROVIDES_${PN}-libasound = "libasound"
PROVIDES_${PN}-alsa-conf-base = "alsa-conf-base"
PROVIDES_${PN}-alsa-doc = "alsa-doc"
PROVIDES_${PN}-alsa-dev = "alsa-dev"

FILES_${PN}-dbg += "${libdir}/alsa-lib/*/.debu*"
FILES_${PN}-libasound = "${libdir}/libasound.so.*"
FILES_${PN}-alsa-server = "${bindir}/*"
FILES_${PN}-alsa-conf = "${datadir}/alsa/"
FILES_${PN}-alsa-dev += "${libdir}/pkgconfig/ /usr/include/ ${datadir}/aclocal/*"
FILES_${PN}-alsa-conf-base = "\
${datadir}/alsa/alsa.conf \
${datadir}/alsa/cards/aliases.conf \
${datadir}/alsa/pcm/default.conf \
${datadir}/alsa/pcm/dmix.conf \
${datadir}/alsa/pcm/dsnoop.conf"

RDEPENDS_libasound = "alsa-conf-base"