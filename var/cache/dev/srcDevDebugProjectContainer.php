<?php

// This file has been auto-generated by the Symfony Dependency Injection Component for internal use.

if (\class_exists(\ContainerMz2bS4h\srcDevDebugProjectContainer::class, false)) {
    // no-op
} elseif (!include __DIR__.'/ContainerMz2bS4h/srcDevDebugProjectContainer.php') {
    touch(__DIR__.'/ContainerMz2bS4h.legacy');

    return;
}

if (!\class_exists(srcDevDebugProjectContainer::class, false)) {
    \class_alias(\ContainerMz2bS4h\srcDevDebugProjectContainer::class, srcDevDebugProjectContainer::class, false);
}

return new \ContainerMz2bS4h\srcDevDebugProjectContainer(array(
    'container.build_hash' => 'Mz2bS4h',
    'container.build_id' => 'fe7d7af7',
    'container.build_time' => 1567091392,
));
