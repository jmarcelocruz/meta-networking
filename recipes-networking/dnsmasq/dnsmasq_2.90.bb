DESCRIPTION = "dnsmasq provides network infrastructure for small networks"
HOMEPAGE = "https://dnsmasq.org/doc.html"
LICENSE = "GPL-2.0-only | GPL-3.0-only"
LIC_FILES_CHKSUM ="file://COPYING-v3;md5=d32239bcb673463ab874e80d47fae504 \
                   file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI = "https://thekelleys.org.uk/dnsmasq/dnsmasq-${PV}.tar.xz"
SRC_URI[sha256sum] = "8e50309bd837bfec9649a812e066c09b6988b73d749b7d293c06c57d46a109e4"

EXTRA_OEMAKE = "DESTDIR=${D} PREFIX=/usr LDFLAGS="${LDFLAGS} -Wl,--hash-style=gnu""

do_install() {
    oe_runmake install
    install -d ${D}/etc
    install ${S}/dnsmasq.conf.example ${D}/etc/dnsmasq.conf
}
